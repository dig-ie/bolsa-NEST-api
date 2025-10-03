import { ApiProperty } from '@nestjs/swagger';

export class AssetResponseDto {
  @ApiProperty({
    description: 'ID único do asset',
    example: 1,
  })
  id: number;

  @ApiProperty({
    description: 'Nome do ativo',
    example: 'Petróleo Brasileiro S.A.',
  })
  name: string;

  @ApiProperty({
    description: 'Símbolo do ativo (ticker)',
    example: 'PETR4',
  })
  symbol: string;

  @ApiProperty({
    description: 'Data de criação do asset',
    example: '2024-01-01T00:00:00.000Z',
  })
  createdAt: Date;

  @ApiProperty({
    description: 'Data da última atualização do asset',
    example: '2024-01-01T00:00:00.000Z',
  })
  updatedAt: Date;
}
