const express = require('express')
const app = express()
const port = 3001

const {
    getTask,
    getAllTasks,
    createTask,
    updateTask,
    deleteTask
} = require('./controller')

const fs = require('fs')
app.locals.dataFilePath = './tasks.json'

app.use(express.json(0))
app.get('/', (req, res) => res.send('Hello, Strawqqhat'))

app.get('/tasks/:id', getTask)
app.get('/tasks', getAllTasks)

app.post('/tasks', createTask)

app.put('/tasks', updateTask)

app.delete('/tasks/:id', deleteTask)

app.listen(port, () => console.log('Example app listening on port ${port}!'))

// exports.app = app
