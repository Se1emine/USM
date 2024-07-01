import random
import string


def generate_password(
    length,
    include_lower=True,
    include_upper=True,
    include_numbers=True,
    include_symbols=True,
):
    """
    Генерирует случайный пароль, соответствующий заданным критериям.

    Args:
        length: Длина пароля.
        include_lower: Включать ли строчные буквы (по умолчанию True).
        include_upper: Включать ли прописные буквы (по умолчанию True).
        include_numbers: Включать ли цифры (по умолчанию True).
        include_symbols: Включать ли символы (по умолчанию True).

    Returns:
        Случайный пароль, соответствующий заданным критериям.
    """

    characters = []
    if include_lower:
        characters.extend(string.ascii_lowercase)
    if include_upper:
        characters.extend(string.ascii_uppercase)
    if include_numbers:
        characters.extend(string.digits)
    if include_symbols:
        characters.extend(string.punctuation)

    if not characters:
        raise ValueError("At least one character set must be selected.")

    password = "".join(random.choice(characters) for _ in range(length))
    return password


def save_password(password, purpose):
    """
    Сохраняет пароль и его назначение в текстовый файл без шифрования.

    Args:
        password: Сгенерированный пароль.
        purpose: Описание назначения пароля.
    """

    with open("passwords.txt", "a") as f:
        f.write(f"{purpose}: {password}\n")


def view_password(purpose):
    """
    Позволяет пользователю просмотреть сохраненный пароль по его назначению.

    Args:
        purpose: Описание назначения пароля.
    """

    with open("passwords.txt", "r") as f:
        for line in f:
            stored_purpose, stored_password = line.strip().split(":")
            if stored_purpose == purpose:
                print(f"Пароль для '{purpose}': {stored_password}")
                return
    print(f"Пароль для '{purpose}' не найден.")
