# Android First Compose

Example of application developed with __Jetpack Compose__.

Regarding architecture, it is implemented with my own interpretation of the __Clean/Hexagonal Architecture__.

In this interpretation, we find the layers (__modules__):

- __Framework__ (UI and DataSources)
- __Ports and Adapters__ (ViewModels and Repository)
- __Domain__ (UseCases, Entities)

Libraries in use:

- Kotlin
- Coroutines
- Koin
- Jetpack Compose
- Navigation
- Material Icons Extended
- GMS Play Services Location
- ViewModel
- Retrofit
- JUnit
- MockK

## License

    Copyright 2021 Esteban Latre
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
        http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.