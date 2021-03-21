const { Pool } = require('pg');

const pool = new Pool({ ssl: { rejectUnauthorized: false } });

if (
  !(
    process.env.PGUSER &&
    process.env.PGPASSWORD &&
    process.env.PGDATABASE &&
    process.env.PGHOST &&
    process.env.PGPORT
  )
) {
  console.error(
    'Database settings are not set.  Confirm your .env file is correct.'
  );
}

module.exports = {
  query: (text, params) => {
    console.log('QUERY:', text);
    console.log('PARAMS:', JSON.stringify(params));
    return pool
      .query(text, params)
      .then((result) => {
        console.log('RESULT ROWS: ', result.rows);
        return result;
      })
      .catch((exception) => console.log(exception));
  },
};
