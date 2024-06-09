import { updateActivity } from "./activity.js";

/**
 * Обновляет активность сразу после загрузки страницы и затем каждую минуту.
 * @returns {void} - Ничего не возвращает.
 */
updateActivity();

/**
 * Запускает функцию обновления активности каждые 60 секунд.
 * @returns {number} - Возвращает идентификатор таймера.
 */
setTimeout(updateActivity, 60000);
