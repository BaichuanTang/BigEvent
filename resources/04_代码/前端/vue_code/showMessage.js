//简单的展示信息
/* export  */function simpleMessage(msg){
    console.log(msg)
}

//复杂的展示信息
/* export */ function complexMessage(msg){
    console.log(new Date()+": "+msg)
}

//批量导出
//export {complexMessage as cm,simpleMessage as sm}

//默认导出
export default {complexMessage ,simpleMessage }