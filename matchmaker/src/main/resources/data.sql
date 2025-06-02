
INSERT INTO companies (id, name)
VALUES (1, 'TechCorp'),
       (2, 'European Consultant'),
       (3, 'GetIT');


INSERT INTO positions (id, title, description, company_id)
VALUES (1, 'Backend Developer', 'Develop backend services using Java and Spring Boot.', 1),
       (2, 'DevOps Engineer', 'Manage CI/CD pipelines and cloud infrastructure.', 1),
       (3, 'HR Manager', 'Work along a huge group of human resources experts and help us excel', 2),
       (4, 'Business Analyst', 'Big data from across the glob so to create new ai applications', 2),
       (5, 'Scrum Master', 'Collaborate across developer teams to provide top of the notch software in the area of logistics',3);


INSERT INTO positions_skills (id, name, position_id)
VALUES (1, 'java', 1),
       (2, 'spring boot', 1),
       (3, 'docker', 2),
       (4, 'kubernetes', 2),
       (5, 'ms office', 3),
       (6, 'social science studies', 3),
       (7, 'talkative', 4),
       (8, 'business expert', 5);
