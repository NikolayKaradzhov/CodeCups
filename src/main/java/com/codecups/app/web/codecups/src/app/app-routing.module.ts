import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ContactsComponent} from "./contacts/contacts.component";
import {PrivacyPolicyComponent} from "./privacy-policy/privacy-policy.component";
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {AboutComponent} from "./about/about.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {GeneralTermsComponent} from "./general-terms/general-terms.component";
import {CupsComponent} from "./products/cups/cups.component";
import {CryptoComponent} from "./products/crypto/crypto.component";
import {CartComponent} from "./cart/cart.component";
import {ShoppingCartComponent} from "./shopping-cart/shopping-cart.component";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./services/auth.guard";
import {DashboardComponent} from "./admin/components/dashboard/dashboard.component";
import {UserManagementComponent} from "./admin/components/dashboard/user-management/user-management.component";
import {RegisterComponent} from "./register/register.component";

const routes: Routes = [
  {path: '', redirectTo: '/v0/home', pathMatch: 'full'},
  {path: 'v0/home', component: LandingPageComponent},
  {path: 'v0/contacts', component: ContactsComponent},
  {path: 'v0/privacy-policy', component: PrivacyPolicyComponent},
  {path: 'v0/about', component: AboutComponent},
  {path: 'v0/not-found', component: PageNotFoundComponent},
  {path: 'v0/general-terms', component: GeneralTermsComponent},
  {path: 'v0/products/cups', component: CupsComponent},
  {path: 'v0/products/crypto', component: CryptoComponent},
  {path: 'v0/cart', component: CartComponent},
  {path: 'v0/login-test', component: LoginComponent},
  {path: 'v0/register-test', component: RegisterComponent},
  {path: 'v0/administration/dashboard', component: DashboardComponent, canActivate:[AuthGuard]},
  {path: 'v0/products', component: ShoppingCartComponent},
  {path: 'v0/administration/dashboard/users', component: UserManagementComponent}
  //{path: '**', redirectTo: '/v0/not-found'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [ContactsComponent,
  PrivacyPolicyComponent,
  LandingPageComponent,
  AboutComponent,
  GeneralTermsComponent,
  ShoppingCartComponent,
PageNotFoundComponent]
