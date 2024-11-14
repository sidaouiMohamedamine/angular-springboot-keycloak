// src/app/services/keycloak.service.ts
import { Injectable } from '@angular/core';
import Keycloak from 'keycloak-js';

@Injectable({
  providedIn: 'root',
})
export class KeycloakService {
 // Declaring a private variable to hold the Keycloak instance
 private keycloakAuth: any;

 constructor() {} 

 // Method to initialize Keycloak and return a promise indicating if authentication was successful
 init(): Promise<any> {
   // Configuration object for Keycloak, containing the server URL, realm, and client ID
   const keycloakConfig = {
     url: 'http://localhost:8080', // URL of the Keycloak server
     realm: 'project',             // Name of the Keycloak realm
     clientId: 'angularspring',     // Client ID registered in Keycloak
   };

   // Initializing a new Keycloak instance with the specified configuration
   this.keycloakAuth = new Keycloak(keycloakConfig);

   // Returning a promise that will resolve if Keycloak initializes successfully
   return new Promise((resolve, reject) => {
     // Initiating the Keycloak authentication process with configuration options
     this.keycloakAuth.init({ onLoad: 'login-required', checkLoginIframe: false }).then(
       (authenticated: boolean) => {
         // Logs successful initialization with the authentication status
         console.log('Keycloak initialized', authenticated);
         resolve(authenticated); // Resolves the promise if authenticated
       },
       (error: any) => {
         // Logs any error that occurs during initialization
         console.error('Keycloak initialization failed', error);
         reject(error); // Rejects the promise if there was an error
       }
     );
   });
 }

 // Method to start the Keycloak login process
 login(): void {
   this.keycloakAuth.login(); // Triggers the Keycloak login
 }

 // Method to log the user out and redirect them to the application's home page
 logout(): void {
   this.keycloakAuth.logout({ redirectUri: window.location.origin }); // Triggers Keycloak logout with a redirect
 }

 // Method to get the current authentication token
 getToken(): string {
   return this.keycloakAuth.token || ''; // Returns the token if available, otherwise an empty string
 }

 // Method to check if the user is authenticated
 isAuthenticated(): boolean {
   return !!this.keycloakAuth.token; // Returns true if there is a token, indicating user is authenticated
 }

 // Method to get the username of the currently authenticated user
 getUsername(): string {
   return this.keycloakAuth.tokenParsed?.preferred_username || ''; // Returns the username from the token if available
 }

 // Method to get the roles assigned to the user
 getRoles(): string[] {
   return this.keycloakAuth.tokenParsed?.realm_access?.roles || []; // Returns an array of roles if available
 }
}
