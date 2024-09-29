const express = require('express')
const router = express.Router();

router.get('/', async(res, req) => {
   res.send('List of user')
});

router.post('/post', async(res, req) => {
 const newUser = req.body;
res.send(`Add user: ${JSON.stringify(newUser)}`)
})
module.exports = router;

