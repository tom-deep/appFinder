const express = require('express');
const db = require('../db');

const router = express.Router();

/* GET home page. */
router.get('/', (req, res) => {
  if (req.session.user) {
    res.render('index', { title: 'appFinder', user: req.session.user });
  } else {
    res.redirect('users/login');
  }
});

router.get('/guest', async (req, res) => {
  const query = 'SELECT * FROM apps;';

  const result = await db.query(query);
  res.render('guest', { rows: result.rows });
});

router.get('/user-list', async (req, res) => {
  let query = 'SELECT * FROM apps';
  const params = [];
  if (req.query.name) {
    query += ' WHERE name ILIKE $1';
    params.push('%' + req.query.name + '%');
  }
  if (req.query.category) {
    query += ' WHERE category ILIKE $1';
    params.push(req.query.category);
  }
  if (req.query.price) {
    query += ' WHERE price <= $1 ';
    params.push(req.query.price);
  }

  if (req.query.sort === 'name') {
    query += ' ORDER BY name';
  } else if (req.query.sort === 'category') {
    query += ' ORDER BY category';
  } else if (req.query.sort === 'price') {
    query += ' ORDER BY price DESC';
  }
  const result = await db.query(query, params);
  res.render('user-list', { rows: result.rows });
});

router.get('/admin-list', async (req, res) => {
  let query = 'SELECT * FROM apps';
  const params = [];
  if (req.query.name) {
    query += ' WHERE name ILIKE $1';
    params.push('%' + req.query.name + '%');
  }
  if (req.query.category) {
    query += ' WHERE category ILIKE $1';
    params.push(req.query.category);
  }
  if (req.query.price) {
    query += ' WHERE price <= $1 ';
    params.push(req.query.price);
  }

  if (req.query.sort === 'name') {
    query += ' ORDER BY name';
  } else if (req.query.sort === 'category') {
    query += ' ORDER BY category';
  } else if (req.query.sort === 'price') {
    query += ' ORDER BY price DESC';
  }
  const result = await db.query(query, params);
  res.render('admin-list', { rows: result.rows });
});
router.get('/add-review/:id', async (req, res) => {
  const query = 'SELECT * FROM apps WHERE id = $1;';
  const params = [req.params.id];
  const result = await db.query(query, params);

  res.render('add-review', { rows: result.rows });
});

router.post('add-review/:id', async (req, res) => {
  const query = 'UPDATE apps SET review[1] = $2 WHERE id = $1;';
  const params = [req.params.id, req.body.review];
  await db.query(query, params);

  const rowsquery = 'SELECT * FROM apps WHERE id = $1;';
  const params2 = [req.params.id];
  const result = await db.query(rowsquery, params2);

  res.render('app-view/:id', { rows: result.rows });
});
router.get('/edit-app/:id', async (req, res) => {
  const query = 'SELECT * FROM apps WHERE id = $1;';
  const params = [req.params.id];
  const result = await db.query(query, params);
  res.render('edit-app', { app: result.rows[0] });
});

router.post('/edit-app/:id', async (req, res) => {
  const query =
    'UPDATE apps SET name = $2, category = $3, price = $4, description = $5, reviews = $6 WHERE id = $1;';
  const params = [
    req.params.id,
    req.body.name,
    req.body.category,
    req.body.price,
    req.body.description,
    req.body.reviews,
  ];
  await db.query(query, params);

  const newquery = 'SELECT * FROM apps WHERE id = $1;';
  const newparams = [req.params.id];
  const result = await db.query(newquery, newparams);

  res.render('app-view', { rows: result.rows });
});

router.get('/app-view/:id', async (req, res) => {
  const query = 'SELECT * FROM apps WHERE id = $1;';
  const params = [req.params.id];
  const result = await db.query(query, params);

  res.render('app-view', { rows: result.rows });
});

router.get('/addapp', (req, res) => {
  res.render('addapp-form');
});

router.post('/add-to-waitlist', async (req, res) => {
  const query1 =
    'INSERT INTO waitlist (name, category, price, description, publisher, link, version) VALUES ($1, $2, $3, $4, $5, $6, $7);';
  const params1 = [
    req.body.name,
    req.body.category,
    req.body.price,
    req.body.description,
    req.body.publisher,
    req.body.link,
    req.body.version,
  ];

  await db.query(query1, params1);
  res.render('submission-received');
});
router.get('/backhome', (req, res) => {
  res.render('login');
});

router.get('/view-wait-list', async (req, res) => {
  const query = 'SELECT * FROM waitlist;';
  const result = await db.query(query);
  res.render('waitlist', { rows: result.rows });
});

/*
router.get('/confirm/:id', async (req, res) => {
  const params = [req.params.id];
  const name = 'SELECT name FROM waitlist WHERE name = $1;';

  const nameresult = await db.query(name, params);

});
*/
router.get('/deny/:id', async (req, res) => {
  const query = 'DELETE FROM waitlist WHERE id = $1;';
  const params = [req.params.id];
  await db.query(query, params);

  const query2 = 'SELECT * FROM waitlist;';
  const result = await db.query(query2);
  res.render('waitlist', { rows: result.rows });
});
module.exports = router;
