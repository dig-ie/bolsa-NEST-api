import { IsString, IsOptional, Length, Matches } from 'class-validator';
import { ApiPropertyOptional } from '@nestjs/swagger';

export class UpdateAssetDto {
  @ApiPropertyOptional({
    description: 'Nome do ativo',
    example: 'Petróleo Brasileiro S.A.',
    minLength: 2,
    maxLength: 100,
  })
  @IsOptional()
  @IsString({ message: 'O nome deve ser uma string' })
  @Length(2, 100, { message: 'O nome deve ter entre 2 e 100 caracteres' })
  name?: string;

  @ApiPropertyOptional({
    description: 'Símbolo do ativo (ticker)',
    example: 'PETR4',
    pattern: '^[A-Z0-9]{2,10}$',
  })
  @IsOptional()
  @IsString({ message: 'O símbolo deve ser uma string' })
  @Length(2, 10, { message: 'O símbolo deve ter entre 2 e 10 caracteres' })
  @Matches(/^[A-Z0-9]+$/, { 
    message: 'O símbolo deve conter apenas letras maiúsculas e números' 
  })
  symbol?: string;
}