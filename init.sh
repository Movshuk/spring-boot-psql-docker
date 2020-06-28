#!/bin/bash
set -e

psql -U postgres <<-EOSQL
  SELECT 'CREATE DATABASE myDb' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'myDb')\gexec
EOSQL