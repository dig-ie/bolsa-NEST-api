import { Injectable, NotFoundException } from '@nestjs/common';
import { CreateAssetDto } from './dto/create-asset.dto';
import { UpdateAssetDto } from './dto/update-asset.dto';

export interface Asset {
  id: number;
  name: string;
  symbol: string;
}

@Injectable()
export class AssetsService {
  private assets: Asset[] = [];
  private nextId = 1;

  create(createAssetDto: CreateAssetDto): Asset {
    const asset: Asset = {
      id: this.nextId++,
      ...createAssetDto,
    };
    this.assets.push(asset);
    return asset;
  }

  findAll(): Asset[] {
    return this.assets;
  }

  findOne(id: number): Asset {
    const asset = this.assets.find(a => a.id === id);
    if (!asset) throw new NotFoundException('Ativo não encontrado');
    return asset;
  }

  update(id: number, updateAssetDto: UpdateAssetDto): Asset {
    const asset = this.findOne(id);
    Object.assign(asset, updateAssetDto);
    return asset;
  }

  remove(id: number): void {
    const index = this.assets.findIndex(a => a.id === id);
    if (index === -1) throw new NotFoundException('Ativo não encontrado');
    this.assets.splice(index, 1);
  }
}