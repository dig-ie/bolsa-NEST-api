@echo off
REM Script de setup para desenvolvimento no Windows

echo 🚀 Configurando ambiente de desenvolvimento...

REM Verifica se o Docker está rodando
docker info >nul 2>&1
if %errorlevel% neq 0 (
    echo ❌ Docker não está rodando. Por favor, inicie o Docker Desktop.
    pause
    exit /b 1
)

REM Cria arquivo .env se não existir
if not exist .env (
    echo 📝 Criando arquivo .env...
    (
        echo # Configurações do Banco de Dados
        echo DATABASE_URL="postgresql://user:bolsa2024!@localhost:5433/bolsa_sim?schema=public"
        echo.
        echo # Configurações da Aplicação
        echo NODE_ENV=development
        echo PORT=3000
        echo.
        echo # Configurações do Prisma
        echo PRISMA_GENERATE_DATAPROXY=false
    ) > .env
    echo ✅ Arquivo .env criado!
) else (
    echo ✅ Arquivo .env já existe
)

REM Para containers existentes
echo 🛑 Parando containers existentes...
docker-compose -f docker-compose.dev.yml down

REM Inicia os containers
echo 🐳 Iniciando containers...
docker-compose -f docker-compose.dev.yml up --build -d

REM Aguarda o banco estar pronto dinamicamente
echo ⏳ Aguardando banco de dados ficar pronto...
:wait_db
docker-compose -f docker-compose.dev.yml exec -T db pg_isready -U user -d bolsa_sim >nul 2>&1
if %errorlevel% neq 0 (
    echo    Aguardando conexão com o banco...
    timeout /t 2 /nobreak >nul
    goto wait_db
)
echo ✅ Banco de dados pronto!

REM Aguarda a API estar rodando
echo 🔍 Aguardando API ficar pronta...
set /a max_attempts=30
set /a attempt=0
:wait_api
if %attempt% geq %max_attempts% (
    echo ⚠️ API não respondeu após %max_attempts% tentativas. Verifique os logs com:
    echo    docker-compose -f docker-compose.dev.yml logs -f api
    goto end_wait
)
curl -f http://localhost:3000 >nul 2>&1
if %errorlevel% equ 0 (
    echo ✅ API está rodando em http://localhost:3000
    goto end_wait
)
echo    Aguardando API responder... (tentativa %attempt%/%max_attempts%)
timeout /t 2 /nobreak >nul
set /a attempt+=1
goto wait_api
:end_wait

echo 🎉 Setup concluído!
echo.
echo 🌐 Serviços disponíveis:
echo    API: http://localhost:3000
echo    Prisma Studio: http://localhost:5555
echo.
echo 👤 Usuários de teste criados:
echo    Admin: admin@bolsa.com / admin123
echo    Teste: test@bolsa.com / test123
echo.
echo 📋 Comandos úteis:
echo    Ver logs: docker-compose -f docker-compose.dev.yml logs -f
echo    Parar: docker-compose -f docker-compose.dev.yml down
echo    Resetar banco: docker-compose -f docker-compose.dev.yml down -v
echo    Prisma Studio: docker-compose -f docker-compose.dev.yml up prisma-studio

pause
