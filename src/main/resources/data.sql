INSERT INTO essen (art, name, preis)
VALUES
('mit Fleisch', 'Burger', 7.50),
('mit Fisch', 'Fischburger', 1.99),
('vegetarisch', 'Salat', 3),
('vegan', 'Linsensuppe', 23.50),
('mit Fleisch', 'Lasagne', 4.50),
('mit Fisch', 'Forelle', 12.50);

INSERT INTO essensplan (kalenderwoche)
VALUES
(10),
(11),
(12),
(13),
(14),
(15),
(16);

INSERT INTO user (username, password, role)
VALUES
('admin', '$2a$10$2/76swzTgfzVzmMGDR8UEO4s8y0WzdaooQtot0Rodvr90FDDj0qr6', 'admin'),
('user', '$2a$10$2/76swzTgfzVzmMGDR8UEO4s8y0WzdaooQtot0Rodvr90FDDj0qr6', 'user'),
('ichbineintest', '$2a$10$2/76swzTgfzVzmMGDR8UEO4s8y0WzdaooQtot0Rodvr90FDDj0qr6', 'user');

INSERT INTO essensplan_essen_pro_woche (essensplan_id, essen_pro_woche_id, essen_pro_woche_key)
VALUES
(1, 4, 0),
(1, 3, 1),
(1, 1, 2),
(1, 5, 3),
(1, 2, 4),
(2, 3, 0),
(2, 2, 1),
(2, 5, 2),
(2, 6, 3),
(2, 4, 4);

