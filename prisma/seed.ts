import { PrismaClient } from "@prisma/client";
import * as bcrypt from "bcryptjs";

const prisma = new PrismaClient();

async function main() {
  console.log("🌱 Iniciando seed de dados...");

  // Criar usuário administrador
  const hashedPassword = await bcrypt.hash("admin123", 10);

  const adminUser = await prisma.user.upsert({
    where: { email: "admin@bolsa.com" },
    update: {},
    create: {
      id: "admin-001",
      email: "admin@bolsa.com",
      password: hashedPassword,
      name: "Administrador",
      role: "admin",
    },
  });

  // Criar usuário de teste
  const testUserPassword = await bcrypt.hash("test123", 10);

  const testUser = await prisma.user.upsert({
    where: { email: "test@bolsa.com" },
    update: {},
    create: {
      id: "user-001",
      email: "test@bolsa.com",
      password: testUserPassword,
      name: "Usuário Teste",
      role: "user",
    },
  });

  console.log("✅ Seed concluído!");
  console.log("👤 Usuários criados:");
  console.log(`   Admin: admin@bolsa.com / admin123`);
  console.log(`   Teste: test@bolsa.com / test123`);
}

main()
  .catch((e) => {
    console.error("❌ Erro no seed:", e);
    process.exit(1);
  })
  .finally(async () => {
    await prisma.$disconnect();
  });

