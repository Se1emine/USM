import math


def calculate_fall_time(height):
    """
    Рассчитывает время падения объекта с заданной высоты.

    Args:
      height: Высота падения в метрах.

    Returns:
      Время падения в секундах.
    """
    if math.isnan(height):
        raise ValueError("Высота должна быть числом.")

    gravity_acceleration = 9.81  # Ускорение свободного падения (м/с²)
    return math.sqrt(2 * height / gravity_acceleration)


try:
    height = float(input("Введите высоту падения (в метрах): "))
    fall_time = calculate_fall_time(height)
    print(f"Время падения: {fall_time:.2f} секунд")
except ValueError as error:
    print(f"Ошибка: {error}")
