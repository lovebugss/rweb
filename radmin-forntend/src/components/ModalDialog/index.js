import React from "react";
import "./style.css";
import { message } from 'antd';

class ModalDialog extends React.Component {
  constructor(props) {
    super(props);
      const {msg} = this.props;
      if(msg.type === "error"){

          message.error(msg.content);
      }

      if(msg.type === "success"){
          message.success(msg.content);
      }
      if(msg.type === "warning"){
          message.warning(msg.content);
      }
  }

  render() {
    return null;
  }
}

export default ModalDialog;
