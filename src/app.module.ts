import { Module } from "@nestjs/common";
import { AppController } from "./app.controller";
import { AppService } from "./app.service";
import { AssetsModule } from "./assets/assets.module";
import { UsersModule } from "./users/users.module";

@Module({
  imports: [AssetsModule, UsersModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
