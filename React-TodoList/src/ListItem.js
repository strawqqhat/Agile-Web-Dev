import React, {Component} from 'react';
import './ListItem.css'


const ListItem = (props) => {
    const item = props.item;

    
    if(item.done) {
        return <p class="item"><input type="checkbox" checked="checked" />{item.content}</p>
    }else {
        return <p class="item"><input type="checkbox" />{item.content}</p>
    }
}


    

export default ListItem;