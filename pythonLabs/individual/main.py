import nltk

nltk.download("punkt")
from nltk.tokenize import sent_tokenize, word_tokenize
from nltk.corpus import stopwords

nltk.download("stopwords")
from nltk.stem import PorterStemmer

nltk.download("PorterStemmer")
import heapq
import re


def preprocess_text(text):
    """
    Предварительная обработка текста для генерации заголовков.

    Args:
      text: Текст, для которого нужно сгенерировать заголовок.

    Returns:
      Список обработанных слов.
    """
    # Очистка текста от пунктуации и преобразование к нижнему регистру
    text = re.sub(r"[^\w\s]", "", text).lower()
    # Разделение текста на предложения
    sentences = sent_tokenize(text)
    # Разделение предложений на слова
    words = [word_tokenize(sentence) for sentence in sentences]
    # Удаление стоп-слов
    stop_words = set(stopwords.words("russian"))
    filtered_words = [
        [word for word in sentence if word not in stop_words] for sentence in words
    ]
    # Стемминг слов
    stemmer = PorterStemmer()
    stemmed_words = [
        [stemmer.stem(word) for word in sentence] for sentence in filtered_words
    ]
    return stemmed_words


def generate_title(text, max_length=5):
    """
    Генерация заголовка из текста.

    Args:
      text: Текст, для которого нужно сгенерировать заголовок.
      max_length: Максимальная длина заголовка.

    Returns:
      Заголовок, сгенерированный из текста.
    """
    # Получение обработанных слов
    processed_words = preprocess_text(text)
    # Подсчет частоты слов
    word_frequencies = {}
    for sentence in processed_words:
        for word in sentence:
            if word in word_frequencies:
                word_frequencies[word] += 1
            else:
                word_frequencies[word] = 1
    # Выбор самых частотных слов
    most_frequent_words = heapq.nlargest(
        max_length, word_frequencies.keys(), key=word_frequencies.get
    )
    # Объединение слов в заголовок
    title = " ".join(most_frequent_words)
    return title.capitalize()


if __name__ == "__main__":
    # Запрос текста у пользователя
    text = input("Введите текст, для которого хотите сгенерировать заголовок: ")
    # Генерация заголовка
    generated_title = generate_title(text)
    # Вывод сгенерированного заголовка
    print(f"Сгенерированный заголовок: {generated_title}")
