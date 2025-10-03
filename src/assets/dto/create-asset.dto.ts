import { IsString, IsNotEmpty, Length, Matches, IsOptional } from 'class-validator';
import { ApiProperty } from '@nestjs/swagger';

export class CreateAssetDto {
  @ApiProperty({
    description: 'Nome do ativo',
    example: 'Petróleo Brasileiro S.A.',
    minLength: 2,
    maxLength: 100,
  })
  @IsString({ message: 'O nome deve ser uma string' })
  @IsNotEmpty({ message: 'O nome é obrigatório' })
  @Length(2, 100, { message: 'O nome deve ter entre 2 e 100 caracteres' })
  name: string;

  @ApiProperty({
    description: 'Símbolo do ativo (ticker)',
    example: 'PETR4',
    pattern: '^[A-Z0-9]{2,10}$',
  })
  @IsString({ message: 'O símbolo deve ser uma string' })
  @IsNotEmpty({ message: 'O símbolo é obrigatório' })
  @Length(2, 10, { message: 'O símbolo deve ter entre 2 e 10 caracteres' })
  @Matches(/^[A-Z0-9]+$/, { 
    message: 'O símbolo deve conter apenas letras maiúsculas e números' 
  })
  symbol: string;
}