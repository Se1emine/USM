/**
 * Получает случайную активность из указанного URL.
 * @param {string} [url=""] - URL, с которого нужно получить данные. По умолчанию используется пустая строка.
 * @returns {Promise<string>} - Возвращает случайную активность.
 */
const getRandomActivity = async (url = "") => {
  try {
    const response = await fetch(url);
    const data = await response.json();
    return data.fact;
  } catch (error) {
    console.error(error);
    return "К сожалению, произошла ошибка";
  }
};

/**
 * Обновляет активность на веб-странице.
 * @param {string} [url="https://catfact.ninja/fact"] - URL, с которого будет получена активность. По умолчанию используется "https://catfact.ninja/fact".
 * @returns {Promise<void>} - Возвращает Promise без данных.
 */
const updateActivity = async (url = "https://catfact.ninja/fact") => {
  const activityElement = document.getElementById("activity");
  const activity = await getRandomActivity(url);
  activityElement.textContent = activity;
};

export { updateActivity };
