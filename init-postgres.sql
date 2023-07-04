SELECT 'CREATE DATABASE sensors'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'sensors')\gexec