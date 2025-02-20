import Article from './Article';

function ArticleList() {
  const articles = [
    { id: 1, title: 'Первая статья', text: 'Это текст первой статьи.' },
    { id: 2, title: 'Вторая статья', text: 'Это текст второй статьи.' },
    { id: 3, title: 'Третья статья', text: 'Это текст третьей статьи.' },
    { id: 4, title: 'Четвертая статья', text: 'Это текст четвертой статьи.' },
  ];

  return (
    <main>
      {articles.map((article) => (
        <Article key={article.id} title={article.title} text={article.text} />
      ))}
    </main>
  );
}

export default ArticleList;