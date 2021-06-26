import { environment } from "../environments/environment";

export const apiBaseUrl = environment.production ? "https://codecups.com" : "http://localhost:8080"
export const productsUrl = apiBaseUrl + "/products"
