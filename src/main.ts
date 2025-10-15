import { NestFactory } from '@nestjs/core';
import { ValidationPipe, Logger } from '@nestjs/common';
import { SwaggerModule, DocumentBuilder } from '@nestjs/swagger';
import { AppModule } from './app.module';
import { HttpExceptionFilter } from './common/filters/http-exception.filter';

async function bootstrap() {
  const logger = new Logger('Bootstrap');
  
  const app = await NestFactory.create(AppModule);
  
 
  app.useGlobalFilters(new HttpExceptionFilter());
  

  
  

  app.enableCors({
    origin: process.env.CORS_ORIGIN || '*',
    methods: ['GET', 'POST', 'PUT', 'DELETE', 'PATCH'],
    allowedHeaders: ['Content-Type', 'Authorization'],
  });
  

  const config = new DocumentBuilder()
    .setTitle('Bolsa API')
    .setDescription('API para sistema de bolsa de valores')
    .setVersion('1.0')
    .addTag('Assets', 'Operações relacionadas aos assets')
    .build();
  
  const document = SwaggerModule.createDocument(app, config);
  SwaggerModule.setup('api/docs', app, document, {
    swaggerOptions: {
      persistAuthorization: true,
    },
  });
  
  const port = process.env.PORT ?? 3000;
  await app.listen(port);
  
  logger.log(`🚀 Aplicação rodando na porta ${port}`);
  logger.log(`📚 Documentação Swagger disponível em: http://localhost:${port}/api/docs`);
}

bootstrap().catch((error) => {
  const logger = new Logger('Bootstrap');
  logger.error('❌ Erro ao iniciar a aplicação:', error);
  process.exit(1);
});
