CREATE TABLE IF NOT EXISTS public.language_settings (
    id BIGINT NOT NULL PRIMARY KEY,
    language_name TEXT NOT NULL,
    user_id BIGINT NOT NULL,
    update_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE IF NOT EXISTS public.security_settings (
    id BIGINT NOT NULL PRIMARY KEY,
    two_factor_authentication BOOLEAN NOT NULL,
    user_id BIGINT NOT NULL,
    update_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE IF NOT EXISTS public.theme_settings (
    id BIGINT NOT NULL PRIMARY KEY,
    theme_name TEXT NOT NULL,
    user_id BIGINT NOT NULL,
    update_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    create_date TIMESTAMP WITHOUT TIME ZONE NOT NULL
);