const fs = require("fs")

const {
    asyncReadFile,
    asyncWriteFile
} = require('./dao')

exports.getTask = async (req, res) => {
    const id = req.params.id
    const file = await asyncReadFile(req.app.locals.dataFilePath)
    const task = JSON.parse(file).filter(v => v.id == id)
    task.length == 0 ? res.status(404).send(id) : res.send(task)
}

exports.getAllTasks = (req, res) => fs.readFile(req.app.locals.dataFilePath, 'utf-8', (err, data) => {
    if(err) {
        return res.status(500).send()
    }
    res.send(JSON.parse(data))
})

exports.createTask = async (req, res) => {
    const newTask = req.body
    const file = await asyncReadFile(req.app.locals.dataFilePath)
    const tasks = JSON.parse(file)
    if(tasks.filter(v => v.id === newTask.id).length != 0) {
        res.status(400).send()
    } else {
        tasks.push(newTask)
        await asyncWriteFile(JSON.stringify(tasks), req.app.locals.dataFilePath)
        res.status(201).send(tasks)
    }
}

exports.updateTask = async (req, res) => {
    const put = req.body
    const file = await asyncReadFile(req.app.locals.dataFilePath)
    const tasks = JSON.parse(file)
    const candidates = tasks.filter(v => v.id === put.id)
    if(candidates.length === 0) {
        this.createTask(req, res)
    } else {
        tasks.forEach((value, index, array) => {
            if (value.id === put.id) {
                array[index] = {
                    ...value,
                    ...put
                }
            }
        })
        await asyncWriteFile(JSON.stringify(tasks), req.app.locals.dataFilePath)
        res.status(200).send(tasks)
    }
}

exports.deleteTask = async (req, res) => {
    const pid = req.params.id
    const file = await asyncReadFile(req.app.locals.dataFilePath)
    const tasks = JSON.parse(file)
    const newTasks = tasks.filter(v => v.id != pid)
    if (newTasks.length === tasks.length) {
        res.status(404).send(newTasks)
    } else {
        await asyncWriteFile(JSON.stringify(newTasks), req.app.locals.dataFilePath)
        res.status(204).send(newTasks)
    }
}