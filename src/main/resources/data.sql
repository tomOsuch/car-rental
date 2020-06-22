insert into user(id, first_name, last_name, birth_date, pesel, email, phone_number, address, zip_code, city) values
(1, 'Jan', 'Kowalski', '18-01-1988', '2211445566778', 'jankowalski@test.pl', '333-222-111', 'Testowa 1', '11-110', 'Warszawa'),
(2, 'Antoni', 'Testowy', '18-02-1988', '8802185566779', 'jankowalski@test.pl', '333-222-111', 'Testowa 1', '11-110', 'Warszawa');

insert  into category(id, name, description) values
(1, 'Kombi', 'Samoch z dużym bagażnikiem'),
(2, 'Sedan', 'Limuzyna');

insert into rent(id, car_brand, car_model, rej_number, vin_number, serial_number, category_id) values
(1, 'Opel', 'Astra', 'WE133ME', 'MG14NO09876801','12341', 1),
(2, 'Opel', 'Astra', 'WE133FN', 'MG147O09876801','12342', 2),
(3, 'Skoda', 'Octavia', 'WE177ME', 'MG14KO09876801','12343', 1);