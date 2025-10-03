import { HttpException, HttpStatus } from '@nestjs/common';

export class AssetNotFoundException extends HttpException {
  constructor(id: number) {
    super(
      {
        statusCode: HttpStatus.NOT_FOUND,
        message: `Asset com ID ${id} não encontrado`,
        error: 'Asset Not Found',
        timestamp: new Date().toISOString(),
      },
      HttpStatus.NOT_FOUND,
    );
  }
}

export class AssetAlreadyExistsException extends HttpException {
  constructor(symbol: string) {
    super(
      {
        statusCode: HttpStatus.CONFLICT,
        message: `Asset com símbolo ${symbol} já existe`,
        error: 'Asset Already Exists',
        timestamp: new Date().toISOString(),
      },
      HttpStatus.CONFLICT,
    );
  }
}

export class InvalidAssetDataException extends HttpException {
  constructor(message: string) {
    super(
      {
        statusCode: HttpStatus.BAD_REQUEST,
        message,
        error: 'Invalid Asset Data',
        timestamp: new Date().toISOString(),
      },
      HttpStatus.BAD_REQUEST,
    );
  }
}

export class AssetServiceException extends HttpException {
  constructor(message: string, cause?: any) {
    super(
      {
        statusCode: HttpStatus.INTERNAL_SERVER_ERROR,
        message: `Erro interno do serviço de assets: ${message}`,
        error: 'Asset Service Error',
        timestamp: new Date().toISOString(),
        cause: cause?.message || cause,
      },
      HttpStatus.INTERNAL_SERVER_ERROR,
    );
  }
}
