INSERT INTO city (name) VALUE ('Lviv');
INSERT INTO city (name) VALUE ('Lutsk');
INSERT INTO city (name) VALUE ('Kyiv');
INSERT INTO city (name) VALUE ('Bukovel');
INSERT INTO city (name) VALUE ('Truskavets`');
INSERT INTO city (name) VALUE ('Ivano-Frankivk');
INSERT INTO city (name) VALUE ('Vinnutsa');
INSERT INTO city (name) VALUE ('Odessa');
INSERT INTO category (name) VALUE ('single');
INSERT INTO category (name) VALUE ('twins');
INSERT INTO category (name) VALUE ('lux');
INSERT INTO category (name) VALUE ('president');
INSERT INTO category (name) VALUE ('double');
INSERT INTO payment_type (name) VALUE ('cash');
INSERT INTO payment_type (name) VALUE ('card');
INSERT INTO hotel (name, star_amount, street, number_of_building, phone_number, city_id, about) VALUES ('Edem Resort Medical Spa', 5, 'Naukova', 18, '097 745 5369', 1,'Today "Edem Resort" is exactly the place where absolute harmony reigns. The country complex was created for a pleasant rest of the soul and body, recuperation, as well as filling with the energy of nature!');
INSERT INTO hotel (name, star_amount, street, number_of_building, phone_number, city_id, about) VALUES ('Noble Boutique Hotel', 4, 'Kryviy val', 39, '098 764 9773', 2, 'A modest hotel on a tree-lined street. Located 1 minute walk from the bus station. An 11-minute walk is the 14th century Lubart Castle, and a 15-minute walk from the Lutsk Zoo.');
INSERT INTO hotel (name, star_amount, street, number_of_building, phone_number, city_id, about) VALUES ('Sky Loft Hotel', 4, 'Espladana', 17, '044 222 2727', 3, 'Sky Loft Kyiv by Rixwell is located in the very center of Kiev. Popular nearby attractions include the Olympic National Sports Complex (600 meters), Khreshchatyk Street (1 km) and Vladimirsky Cathedral (16 minutes` walk).');
INSERT INTO hotel (name, star_amount, street, number_of_building, phone_number, city_id, about) VALUES ('F&B Spa Resort', 5, 'Polyanytsa', 13, '050 464 3355', 4, 'F&B SPA RESORT is located in the heart of the Carpathians, amidst mighty peaks and incredible landscapes. We offer many high-level services and services to make each of our guests feel cozy and comfortable at home.');
INSERT INTO hotel (name, star_amount, street, number_of_building, phone_number, city_id, about) VALUES ('Higina Spa', 4, 'Boryslavska', 29, '067 370 4853', 5,'This quiet spa hotel is located in a green area, a 9-minute walk from the walking paths in Central Park Adamovka and a 13-minute walk from Truskavets Train Station.');
INSERT INTO hotel (name, star_amount, street, number_of_building, phone_number, city_id, about) VALUES ('Reikartz Park', 3, 'Mazepy', 146, '034 259 5595', 6, 'The hotel is located on the outskirts of the city in a chalet-like building next to the City Lake and 3 km from Rynok Square.Each of the simple rooms has free Wi-Fi, a flat-screen TV and a mini fridge.');
INSERT INTO hotel (name, star_amount, street, number_of_building, phone_number, city_id, about) VALUES ('Hotel Villa Venice', 4, 'Modern Bulvar', 36, '097 363 6058', 7,'Villa Venice is located in Vinnytsia, 3.5 km from Pirogov National Museum. It offers a restaurant, free private parking, a seasonal outdoor pool and bar. There is a 24-hour front desk.');
INSERT INTO hotel (name, star_amount, street, number_of_building, phone_number, city_id, about) VALUES ('NEMO Hotel Resort & SPA', 5, 'Plazh Langeron', 25, '048 705 7080', 8, 'This spacious luxury hotel is located on the Black Sea coast, a 3-minute walk from Lanzheron Beach and 10 km from Odessa International Airport. Each luxurious room features a balcony with sea views, free Wi-Fi, a flat-screen TV.');
-- --
INSERT INTO room (hotel_id, category_id, cost) VALUES (1, 1, 5000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (1, 2, 8000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (1, 3, 30000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (1, 4, 60000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (1, 5, 18000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (2, 1, 700);
INSERT INTO room (hotel_id, category_id, cost) VALUES (2, 2, 1000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (2, 3, 5000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (2, 5, 2500);
INSERT INTO room (hotel_id, category_id, cost) VALUES (3, 1, 3000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (3, 2, 3800);
INSERT INTO room (hotel_id, category_id, cost) VALUES (3, 3, 8000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (3, 4, 13000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (3, 5, 5600);
INSERT INTO room (hotel_id, category_id, cost) VALUES (4, 1, 5600);
INSERT INTO room (hotel_id, category_id, cost) VALUES (4, 2, 7200);
INSERT INTO room (hotel_id, category_id, cost) VALUES (4, 3, 12000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (4, 4, 20000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (4, 5, 9000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (5, 1, 2500);
INSERT INTO room (hotel_id, category_id, cost) VALUES (5, 3, 6000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (5, 4, 8000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (5, 5, 4000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (6, 1, 600);
INSERT INTO room (hotel_id, category_id, cost) VALUES (6, 2, 800);
INSERT INTO room (hotel_id, category_id, cost) VALUES (6, 3, 2500);
INSERT INTO room (hotel_id, category_id, cost) VALUES (6, 5, 1000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (7, 1, 700);
INSERT INTO room (hotel_id, category_id, cost) VALUES (7, 2, 850);
INSERT INTO room (hotel_id, category_id, cost) VALUES (7, 3, 2000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (7, 5, 950);
INSERT INTO room (hotel_id, category_id, cost) VALUES (8, 1, 6000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (8, 2, 8000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (8, 3, 18000);
INSERT INTO room (hotel_id, category_id, cost) VALUES (8, 4, 32000)
INSERT INTO room (hotel_id, category_id, cost) VALUES (8, 5, 12000)

 INSERT INTO user (lastname, name, surname, birthday, street, number_of_building, phone_number, login, password, city_id) VALUES ('Typara', 'Typa', 'Typarivna', '2021-09-29', 'Porohova', 20, '0502348156', 'Typara', '1111', 1);
