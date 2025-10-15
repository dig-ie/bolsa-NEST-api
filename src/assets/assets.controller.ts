import { 
  Controller, 
  Get, 
  Post, 
  Body, 
  Param, 
  Put, 
  Delete, 
  ParseIntPipe,
  HttpCode,
  HttpStatus
} from '@nestjs/common';
import { 
  ApiTags, 
  ApiOperation, 
  ApiResponse,
  ApiParam,
  ApiBody
} from '@nestjs/swagger';
import { Assets } from '@prisma/client';
import { AssetsService } from './assets.service';
import { CreateAssetDto } from './dto/create-asset.dto';
import { UpdateAssetDto } from './dto/update-asset.dto';
import { AssetResponseDto } from './dto/asset-response.dto';

@ApiTags('Assets')
@Controller('assets')
export class AssetsController {
  constructor(private readonly assetsService: AssetsService) {}

  @Post()
  @HttpCode(HttpStatus.CREATED)
  @ApiOperation({ summary: 'Criar um novo asset' })
  @ApiBody({ type: CreateAssetDto })
  @ApiResponse({ 
    status: 201, 
    description: 'Asset criado com sucesso',
    type: AssetResponseDto
  })
  async create(@Body() createAssetDto: CreateAssetDto): Promise<Assets> {
    return await this.assetsService.create(createAssetDto);
  }

  @Get()
  @ApiOperation({ summary: 'Listar todos os assets' })
  @ApiResponse({ 
    status: 200, 
    description: 'Lista de assets',
    type: [AssetResponseDto]
  })
  async findAll(): Promise<Assets[]> {
    return await this.assetsService.findAll();
  }

  @Get(':id')
  @ApiOperation({ summary: 'Buscar asset por ID' })
  @ApiParam({ name: 'id', type: 'number', example: 1 })
  @ApiResponse({ 
    status: 200, 
    description: 'Asset encontrado',
    type: AssetResponseDto
  })
  async findOne(@Param('id', ParseIntPipe) id: number): Promise<Assets> {
    return await this.assetsService.findOne(id);
  }

  @Put(':id')
  @ApiOperation({ summary: 'Atualizar asset' })
  @ApiParam({ name: 'id', type: 'number', example: 1 })
  @ApiBody({ type: UpdateAssetDto })
  @ApiResponse({ 
    status: 200, 
    description: 'Asset atualizado',
    type: AssetResponseDto
  })
  async update(
    @Param('id', ParseIntPipe) id: number, 
    @Body() updateAssetDto: UpdateAssetDto
  ): Promise<Assets> {
    return await this.assetsService.update(id, updateAssetDto);
  }

  @Delete(':id')
  @HttpCode(HttpStatus.NO_CONTENT)
  @ApiOperation({ summary: 'Remover asset' })
  @ApiParam({ name: 'id', type: 'number', example: 1 })
  @ApiResponse({ status: 204, description: 'Asset removido' })
  async remove(@Param('id', ParseIntPipe) id: number): Promise<void> {
    await this.assetsService.remove(id);
  }
}