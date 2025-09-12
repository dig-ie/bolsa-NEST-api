import { Client } from "pg";

describe("Database basic test", () => {
  let client: Client;

  beforeAll(async () => {
    client = new Client({
      host: process.env.DB_HOST || "localhost",
      port: +(process.env.DB_PORT || 5432),
      user: process.env.DB_USER || "user",
      password: process.env.DB_PASS || "pass",
      database: process.env.DB_NAME || "bolsa_sim",
    });
    await client.connect();
  });

  afterAll(async () => {
    await client.end();
  });

  it("should create table test and insert a row", async () => {
    await client.query(`CREATE TABLE IF NOT EXISTS test (
      id SERIAL PRIMARY KEY,
      name TEXT
    )`);
    const insertResult = await client.query(
      "INSERT INTO test (name) VALUES ($1) RETURNING id, name",
      ["registro de teste"]
    );
    expect(insertResult.rows[0]).toHaveProperty("id");
    expect(insertResult.rows[0].name).toBe("registro de teste");
  });
});
