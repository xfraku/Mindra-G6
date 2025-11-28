import { CanActivateFn } from '@angular/router';
import { inject } from '@angular/core';

export const seguridadGuard: CanActivateFn = (route, state) => {
  return true;
};
