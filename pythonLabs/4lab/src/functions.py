def ideal_weight(age, height, gender):
    if gender.upper() == "М":
        ideal_weight = height - 100 - ((height - 150) / 4 + (age - 20) / 4)
    elif gender.upper() == "Ж":
        ideal_weight = height - 100 - ((height - 150) / 2.5 + (age - 20) / 6)
    else:
        return None
    return ideal_weight


def weight_recommendation(current_weight, ideal_weight):
    if current_weight < ideal_weight:
        return "Вам необходимо набрать вес."
    elif current_weight > ideal_weight:
        return "Вам необходимо снизить вес."
    else:
        return "Ваш вес идеальный."
