import { Injectable, BadRequestException } from '@nestjs/common';
import { CreateAssetDto } from './dto/create-asset.dto';
import { UpdateAssetDto } from './dto/update-asset.dto';
import { 
  AssetNotFoundException, 
  AssetAlreadyExistsException, 
  InvalidAssetDataException
} from '../common/exceptions/custom-exceptions';

export interface Asset {
  id: number;
  name: string;
  symbol: string;
  createdAt: Date;
  updatedAt: Date;
}

@Injectable()
export class AssetsService {
  private assets: Asset[] = [];
  private nextId = 1;

  async create(createAssetDto: CreateAssetDto): Promise<Asset> {
    this.validateSymbolUniqueness(createAssetDto.symbol);
    
    const asset: Asset = {
      id: this.nextId++,
      ...createAssetDto,
      symbol: createAssetDto.symbol.toUpperCase(), // Normalizar símbolo
      createdAt: new Date(),
      updatedAt: new Date(),
    };
    
    this.assets.push(asset);
    return asset;
  }

  async findAll(): Promise<Asset[]> {
    return [...this.assets];
  }

  async findOne(id: number): Promise<Asset> {
    if (!this.isValidId(id)) {
      throw new BadRequestException('ID deve ser um número positivo');
    }
    
    const asset = this.assets.find(a => a.id === id);
    
    if (!asset) {
      throw new AssetNotFoundException(id);
    }
    
    return asset;
  }

  async update(id: number, updateAssetDto: UpdateAssetDto): Promise<Asset> {
    if (!this.isValidId(id)) {
      throw new BadRequestException('ID deve ser um número positivo');
    }
    
    if (Object.keys(updateAssetDto).length === 0) {
      throw new BadRequestException('Pelo menos um campo deve ser fornecido para atualização');
    }
    
    const asset = await this.findOne(id);
    
    // Validar símbolo se estiver sendo atualizado
    if (updateAssetDto.symbol && updateAssetDto.symbol !== asset.symbol) {
      this.validateSymbolUniqueness(updateAssetDto.symbol);
      updateAssetDto.symbol = updateAssetDto.symbol.toUpperCase();
    }
    
    Object.assign(asset, updateAssetDto, { updatedAt: new Date() });
    return asset;
  }

  async remove(id: number): Promise<void> {
    if (!this.isValidId(id)) {
      throw new BadRequestException('ID deve ser um número positivo');
    }
    
    const index = this.assets.findIndex(a => a.id === id);
    
    if (index === -1) {
      throw new AssetNotFoundException(id);
    }
    
    this.assets.splice(index, 1);
  }

  private isValidId(id: number): boolean {
    return Number.isInteger(id) && id > 0;
  }

  private validateSymbolUniqueness(symbol: string): void {
    const existingAsset = this.assets.find(a => 
      a.symbol.toUpperCase() === symbol.toUpperCase()
    );
    
    if (existingAsset) {
      throw new AssetAlreadyExistsException(symbol);
    }
  }
}