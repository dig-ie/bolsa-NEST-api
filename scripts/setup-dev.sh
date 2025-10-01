#!/bin/bash

# Script de setup para desenvolvimento
echo "🚀 Configurando ambiente de desenvolvimento..."

# Verifica se o Docker está rodando
if ! docker info > /dev/null 2>&1; then
    echo "❌ Docker não está rodando. Por favor, inicie o Docker Desktop."
    exit 1
fi

# Cria arquivo .env se não existir
if [ ! -f .env ]; then
    echo "📝 Criando arquivo .env..."
    cat > .env << EOF
# Configurações do Banco de Dados
DATABASE_URL="postgresql://user:bolsa2024!@localhost:5433/bolsa_sim?schema=public"

# Configurações da Aplicação
NODE_ENV=development
PORT=3000

# Configurações do Prisma
PRISMA_GENERATE_DATAPROXY=false
EOF
    echo "✅ Arquivo .env criado!"
else
    echo "✅ Arquivo .env já existe"
fi

# Para containers existentes
echo "🛑 Parando containers existentes..."
docker-compose -f docker-compose.dev.yml down

# Remove volumes antigos (opcional - descomente se quiser resetar o banco)
# echo "🗑️ Removendo volumes antigos..."
# docker-compose -f docker-compose.dev.yml down -v

# Inicia os containers
echo "🐳 Iniciando containers..."
docker-compose -f docker-compose.dev.yml up --build -d

# Aguarda o banco estar pronto dinamicamente
echo "⏳ Aguardando banco de dados ficar pronto..."
until docker-compose -f docker-compose.dev.yml exec -T db pg_isready -U user -d bolsa_sim > /dev/null 2>&1; do
  echo "   Aguardando conexão com o banco..."
  sleep 2
done
echo "✅ Banco de dados pronto!"

# Aguarda a API estar rodando
echo "🔍 Aguardando API ficar pronta..."
max_attempts=30
attempt=0
while [ $attempt -lt $max_attempts ]; do
  if curl -f http://localhost:3000 > /dev/null 2>&1; then
    echo "✅ API está rodando em http://localhost:3000"
    break
  fi
  echo "   Aguardando API responder... (tentativa $((attempt + 1))/$max_attempts)"
  sleep 2
  attempt=$((attempt + 1))
done

if [ $attempt -eq $max_attempts ]; then
  echo "⚠️ API não respondeu após $max_attempts tentativas. Verifique os logs com:"
  echo "   docker-compose -f docker-compose.dev.yml logs -f api"
fi

echo "🎉 Setup concluído!"
echo ""
echo "🌐 Serviços disponíveis:"
echo "   API: http://localhost:3000"
echo "   Prisma Studio: http://localhost:5555"
echo ""
echo "👤 Usuários de teste criados:"
echo "   Admin: admin@bolsa.com / admin123"
echo "   Teste: test@bolsa.com / test123"
echo ""
echo "📋 Comandos úteis:"
echo "   Ver logs: docker-compose -f docker-compose.dev.yml logs -f"
echo "   Parar: docker-compose -f docker-compose.dev.yml down"
echo "   Resetar banco: docker-compose -f docker-compose.dev.yml down -v"
echo "   Prisma Studio: docker-compose -f docker-compose.dev.yml up prisma-studio"
