package edu.put.jetpackcomposetrailsapp.repository

val jsonData = """
        [
            {
                "id": 1,
                "name": "Szlak na Turbacz",
                "location": "Gorce",
                "shortDescription": "Popularny szlak w Gorcach",
                "longDescription": "Szlak na Turbacz rozpoczyna się w miejscowości Obidowa i prowadzi przez malownicze tereny Gorców, oferując wędrowcom niezapomniane widoki na Tatry, Pieniny oraz Beskidy. Przez większość trasy szlak jest łagodny i dobrze przygotowany, co czyni go idealnym wyborem dla rodzin oraz osób poszukujących relaksującego spaceru na łonie natury. Docierając na szczyt Turbacza, najwyższego punktu Gorców, turyści mogą odwiedzić schronisko PTTK.",
                "walkTime": 180,
                "imageId": 1,
                "difficulty": "beginner"
            },
            {
                "id": 2,
                "name": "Czerwony szlak na Rysy",
                "location": "Tatry",
                "shortDescription": "Najwyższy punkt Polski",
                "longDescription": "Czerwony szlak na Rysy jest jednym z najbardziej znanych i jednocześnie najbardziej wymagających szlaków w polskich Tatrach, prowadząc na najwyższy szczyt Polski. Startując z Morskiego Oka, ścieżka wije się stromo w górę, przekraczając granicę polsko-słowacką i oferując wspaniałe widoki na otaczające góry i doliny.",
                "walkTime": 360,
                "imageId": 2,
                "difficulty": "beginner"
            },
            {
                "id": 3,
                "name": "Ścieżka nad Reglami",
                "location": "Tatry",
                "shortDescription": "Łatwy szlak z pięknymi widokami",
                "longDescription": "Ścieżka nad Reglami to idealna propozycja dla rodzin z dziećmi i osób szukających mniej wymagających tras. Szlak oferuje malownicze widoki na doliny i szczyty Tatr Zachodnich, prowadząc przez lasy reglowe.",
                "walkTime": 150,
                "imageId": 3,
                "difficulty": "beginner"
            },
              {
                "id": 4,
                "name": "Szlak na Halę Gąsienicową",
                "location": "Tatry",
                "shortDescription": "Klasyka tatrzańskiego trekkingu",
                "longDescription": "Szlak na Halę Gąsienicową to jedna z najpopularniejszych tras w Tatrach, oferująca wspaniałe widoki i dostęp do schroniska Murowaniec. Trasa jest dobrze przygotowana dla turystów, oferując dostęp do wielu dalszych szlaków.",
                "walkTime": 120,
                "imageId": 4,
                "difficulty": "beginner"
              },
              {
                "id": 5,
                "name": "Dolina Kościeliska",
                "location": "Tatry",
                "shortDescription": "Jedna z najpiękniejszych dolin Tatr",
                "longDescription": "Dolina Kościeliska zachwyca swoim naturalnym pięknem, bogatą florą i fauną. Szlak prowadzi przez Jaskinię Mroźną, Wąwóz Kraków, aż do schroniska na Hali Ornak. Idealne miejsce na jednodniowe wycieczki.",
                "walkTime": 210,
                "imageId": 5,
                "difficulty": "beginner"
              },
              {
                "id": 6,
                "name": "Szlak na Śnieżnik",
                "location": "Sudety",
                "shortDescription": "Najwyższy szczyt Sudetów Środkowych",
                "longDescription": "Śnieżnik to dominujący szczyt w Sudetach Środkowych, oferujący panoramę na całe pasmo oraz sąsiednie góry. Szlak jest dobrze oznakowany, a wędrówka nie jest zbyt wymagająca, co przyciąga wielu turystów.",
                "walkTime": 240,
                "imageId": 6,
                "difficulty": "beginner"
              },
              {
                "id": 7,
                "name": "Błękitny szlak na Szrenicę",
                "location": "Karkonosze",
                "shortDescription": "Malowniczy szlak przez Szklarską Porębę",
                "longDescription": "Błękitny szlak na Szrenicę to doskonała propozycja dla osób pragnących podziwiać piękno Karkonoszy. Trasa prowadzi obok wodospadu Kamieńczyk, przez Schronisko pod Łabskim Szczytem, aż na Szrenicę.",
                "walkTime": 180,
                "imageId": 7,
                "difficulty": "beginner"
              },
              {
                "id": 8,
                "name": "Główny Szlak Sudecki",
                "location": "Sudety",
                "shortDescription": "Najdłuższy szlak w Sudetach",
                "longDescription": "Główny Szlak Sudecki przemierza całe Sudety, od Prudnika do Głuszycy, oferując niezapomniane widoki i różnorodność krajobrazów. Szlak jest wymagający i przeznaczony dla doświadczonych turystów.",
                "walkTime": 5400,
                "imageId": 8,
                "difficulty": "beginner"
              },
                {
                  "id": 9,
                  "name": "Szlak na Babia Górę",
                  "location": "Beskidy",
                  "shortDescription": "Diablak - dach Beskidów",
                  "longDescription": "Szlak na Babia Górę, najwyższy szczyt Beskidów, oferuje spektakularne widoki, szczególnie zimą. Trasa jest dobrze oznakowana, ale może być wymagająca z powodu swojej stromości i zmiennych warunków pogodowych.",
                  "walkTime": 300,
                  "imageId": 9,
                  "difficulty": "beginner"
                },
                {
                  "id": 10,
                  "name": "Czarny szlak na Łysicę",
                  "location": "Góry Świętokrzyskie",
                  "shortDescription": "Najwyższy szczyt Gór Świętokrzyskich",
                  "longDescription": "Łysica, oferująca jedne z najlepszych widoków w Górach Świętokrzyskich, jest dostępna szlakiem z miejscowości Święta Katarzyna. Szlak jest stosunkowo łatwy i prowadzi przez rezerwat przyrody, obfitujący w unikalną florę.",
                  "walkTime": 150,
                  "imageId": 10,
                  "difficulty": "beginner"
                },
                {
                  "id": 11,
                  "name": "Niebieski szlak na Trzy Korony",
                  "location": "Pieniny",
                  "shortDescription": "Ikona Pienin z niezapomnianą panoramą",
                  "longDescription": "Trzy Korony to jeden z najbardziej charakterystycznych szczytów Pienin, oferujący panoramę na Dunajec i Tatry. Szlak z Sromowiec Niżnych jest łatwo dostępny i stanowi jedną z głównych atrakcji Pienińskiego Parku Narodowego.",
                  "walkTime": 180,
                  "imageId": 11,
                  "difficulty": "advanced"
                },
                {
                  "id": 12,
                  "name": "Żółty szlak na Połoninę Caryńską",
                  "location": "Bieszczady",
                  "shortDescription": "Widokowe połoniny Bieszczad",
                  "longDescription": "Połonina Caryńska to jeden z najpiękniejszych szczytów Bieszczad, oferujący rozległe widoki na połoniny i lasy. Szlak z Ustrzyk Górnych jest dobrze oznakowany i dostępny dla większości turystów.",
                  "walkTime": 240,
                  "imageId": 12,
                  "difficulty": "advanced"
                },
                {
                  "id": 13,
                  "name": "Szlak Papieski",
                  "location": "Beskidy",
                  "shortDescription": "Duchowe dziedzictwo Jana Pawła II",
                  "longDescription": "Szlak Papieski w Beskidzie Małym, łączący miejsca związane z pobytem Karola Wojtyły, to propozycja nie tylko dla ciała, ale i dla ducha. Trasa oferuje zarówno piękne krajobrazy, jak i miejsca kultu religijnego.",
                  "walkTime": 180,
                  "imageId": 13,
                  "difficulty": "advanced"
                },
                {
                  "id": 14,
                  "name": "Czerwony szlak na Szyndzielnię",
                  "location": "Beskidy",
                  "shortDescription": "Łatwy dostęp do panoramy Beskidów",
                  "longDescription": "Szyndzielnia, dostępna z Bielska-Białej, to popularny cel wycieczek. Szlak jest łatwy i dobrze przygotowany, a z samego szczytu rozpościera się widok na okoliczne góry.",
                  "walkTime": 120,
                  "imageId": 14,
                  "difficulty": "advanced"
                },
                {
                  "id": 15,
                  "name": "Zielony szlak na Skrzyczne",
                  "location": "Beskidy",
                  "shortDescription": "Najwyższy szczyt Beskidu Śląskiego",
                  "longDescription": "Skrzyczne to cel wielu wycieczek, oferujący rozległe widoki na okolicę. Szlak z Szczyrku jest dobrze oznakowany i choć momentami stromy, to dostępny dla większości turystów.",
                  "walkTime": 240,
                  "imageId": 15,
                  "difficulty": "advanced"
                },
                {
                  "id": 16,
                  "name": "Szlak na Wielką Sowę",
                  "location": "Sudety",
                  "shortDescription": "Dach Gór Sowich",
                  "longDescription": "Wielka Sowa, najwyższy szczyt Gór Sowich, jest doskonałym miejscem obserwacyjnym. Szlak z Przełęczy Jugowskiej jest stosunkowo łatwy i prowadzi przez lasy pełne tajemnic z czasów II wojny światowej.",
                  "walkTime": 180,
                  "imageId": 16,
                  "difficulty": "advanced"
                },
                  {
                    "id": 17,
                    "name": "Czarny szlak na Wysoką Kopa",
                    "location": "Sudety",
                    "shortDescription": "Niezapomniane widoki z Wysokiej Kopy",
                    "longDescription": "Wysoka Kopa to idealny cel dla szukających spokoju i pięknych krajobrazów. Szlak z Jakuszyc jest dobrze oznakowany, prowadząc przez dziewicze obszary Gór Izerskich.",
                    "walkTime": 300,
                    "imageId": 17,
                    "difficulty": "advanced"
                  },
                  {
                    "id": 18,
                    "name": "Szlak na Śnieżnik z Międzygórza",
                    "location": "Sudety",
                    "shortDescription": "Malownicza wędrówka na Śnieżnik",
                    "longDescription": "Śnieżnik z Międzygórza to jeden z najbardziej malowniczych szlaków w Sudetach, oferujący bogatą florę i faunę oraz spektakularne widoki na Karkonosze i Masyw Śnieżnika.",
                    "walkTime": 360,
                    "imageId": 18,
                    "difficulty": "advanced"
                  },
                  {
                    "id": 19,
                    "name": "Czerwony szlak na Tarnicę",
                    "location": "Bieszczady",
                    "shortDescription": "Najwyższy szczyt Bieszczad",
                    "longDescription": "Tarnica, jako najwyższy szczyt Bieszczad, przyciąga wielu turystów. Szlak z Wołosatego jest dobrze oznakowany i oferuje niezapomniane widoki, szczególnie wiosną i jesienią, kiedy to bieszczadzkie połoniny kwitną.",
                    "walkTime": 300,
                    "imageId": 19,
                    "difficulty": "advanced"
                  },
                  {
                    "id": 20,
                    "name": "Niebieski szlak na Łysą Górę",
                    "location": "Świętokrzyskie",
                    "shortDescription": "Szlak na najwyższy szczyt Gór Świętokrzyskich",
                    "longDescription": "Łysa Góra, z historycznym klasztorem na szczycie, to miejsce o wyjątkowym znaczeniu kulturowym i duchowym. Szlak z Nowej Słupi jest łatwy i oferuje piękne widoki na okoliczne lasy.",
                    "walkTime": 90,
                    "imageId": 20,
                    "difficulty": "advanced"
                  }
        ]
    """.trimIndent()