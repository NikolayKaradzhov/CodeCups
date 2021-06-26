import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { FooterComponent } from './shared/footer/footer.component';
import { ContactsComponent } from './contacts/contacts.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { CartComponent } from './cart/cart.component';
import { PrivacyPolicyComponent } from "./privacy-policy/privacy-policy.component";
import { FeatureBoxComponent } from './feature-box/feature-box.component';
import { AboutComponent } from './about/about.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { GeneralTermsComponent } from './general-terms/general-terms.component';
import { RelatedProductsComponent } from './related-products/related-products.component';
import { CupsComponent } from './products/cups/cups.component';
import { CryptoComponent } from './products/crypto/crypto.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { FiltersComponent } from './shopping-cart/filters/filters.component';
import { ProductListComponent } from './shopping-cart/product-list/product-list.component';
import { CarttComponent } from './shopping-cart/cartt/cartt.component';
import { CartItemComponent } from './shopping-cart/cartt/cart-item/cart-item.component';
import { ProductItemComponent } from './shopping-cart/product-list/product-item/product-item.component';
import { HttpClientModule } from "@angular/common/http";
import { UserManagementComponent } from './admin/components/dashboard/user-management/user-management.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import { DashboardComponent } from './admin/components/dashboard/dashboard.component';
import { OrderManagementComponent } from './admin/components/dashboard/order-management/order-management.component';
import { ProductManagementComponent } from './admin/components/dashboard/product-management/product-management.component';
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatIconModule} from '@angular/material/icon';
import {MatSortModule} from "@angular/material/sort";
import { RegisterComponent } from './register/register.component';
import { MatCardModule} from "@angular/material/card";
import {MatSnackBarModule} from "@angular/material/snack-bar";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    ContactsComponent,
    LandingPageComponent,
    CartComponent,
    PrivacyPolicyComponent,
    routingComponents,
    FeatureBoxComponent,
    AboutComponent,
    PageNotFoundComponent,
    GeneralTermsComponent,
    RelatedProductsComponent,
    CupsComponent,
    CryptoComponent,
    ShoppingCartComponent,
    FiltersComponent,
    ProductListComponent,
    CarttComponent,
    CartItemComponent,
    ProductItemComponent,
    UserManagementComponent,
    LoginComponent,
    DashboardComponent,
    OrderManagementComponent,
    ProductManagementComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatIconModule,
    MatSortModule,
    MatCardModule,
    MatSnackBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
