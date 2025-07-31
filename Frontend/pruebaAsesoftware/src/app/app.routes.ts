import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { TurnsComponent } from './turns/turns.component';

export const routes: Routes = [
    { path: "", component: LoginComponent},
    { path: "turns", component: TurnsComponent}
];
