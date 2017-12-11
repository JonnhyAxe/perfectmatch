# Artist app 

>ng new artist-app --routing


#Generating the Artist Components
In this app, a major module is a artis module. It will include artist-list sub component and artist-create sub component.

* artist-list sub component – use for list users.
* artist-create sub component – use for artist creating and editing form.

Use this command to generate use the artist module.
>cd artist-app 

> cd src

>ng generate module artist --routing

Then we need to a service to call the REST services. We called it a artist service.

>ng generate service artist/artist

Now we have to generate sub-components.

>ng generate component /artist/artist-list

>ng generate component /artist/artist-create


1. Add module to the app.module.ts
2. Add path to artist/app.routing.module.ts
3. Implement module and HTML template file  


#Routing
The Routing artist for redirect to the related page base on the url.
Modify artist-routing.module.ts in the artist module


Then, add the ArtistModule into the app.module.ts.



#Artist class 

> ng generate class artist


#Generating the Music Components

>ng generate module music --routing
>cd app/music
>ng generate class music
>ng generate component music-list
>ng generate component music-create

1. Add module to the app.module.ts
2. Add path to music/app.routing.module.ts
3. Implement module and HTML template file  


#Generating the Sample Components

>ng generate module sample --routing
>cd src/app/sample
>ng generate class sample
>ng generate component sample-list
>ng generate component sample-create

1. Add module to the app.module.ts
2. Add path to sample/app.routing.module.ts
3. Implement module and HTML template file  

#Generating the Match Components

>ng generate module match --routing
>cd src/app/match
>ng generate class match
>ng generate component match-list

1. Add module to the app.module.ts
2. Add path to sample/app.routing.module.ts
3. Implement module and HTML template file  


#Generate Services

>ng generate service artist --module=artist
>ng generate service music --module=music
>ng generate service sample --module=sample
>ng generate service match --module=match

This import and adds all modules to the app providers in the app.module.ts
