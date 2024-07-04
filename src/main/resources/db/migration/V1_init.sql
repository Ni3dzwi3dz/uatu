-- Create the enum type for todo_type
CREATE TYPE todo_type AS ENUM (
    'Task',
    'Bill',
    'ShoppingList',
    'Repair'
);

-- Create the todos table
CREATE TABLE IF NOT EXISTS todos (
    id SERIAL PRIMARY KEY,
    todo_id INTEGER NOT NULL,
    todo_type todo_type NOT NULL
);

-- Create separate tables for each type of todo
CREATE TABLE IF NOT EXISTS tasks (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    due_date DATE NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS bills (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    due_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS shopping_lists (
    id SERIAL PRIMARY KEY,
    items JSONB NOT NULL
);

CREATE TABLE IF NOT EXISTS repairs (
    id SERIAL PRIMARY KEY,
    item VARCHAR(255) NOT NULL,
    what_needs_to_be_fixed TEXT NOT NULL
);