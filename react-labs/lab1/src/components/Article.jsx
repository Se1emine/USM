import PropTypes from 'prop-types';

function Article({ title, text }) {
  return (
    <article>
      <h2>{title}</h2>
      <p>{text}</p>
    </article>
  );
}

Article.propTypes = {
  title: PropTypes.string.isRequired,
  text: PropTypes.string.isRequired,
};

export default Article;