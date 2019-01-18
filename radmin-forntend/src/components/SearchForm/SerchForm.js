/**
 * Created by renjp on 2019/1/18.
 */
import React from 'react';
import PropTypes from 'prop-types';
import {
    Form, Row, Col, Input, Button, Icon,
} from 'antd';

function SearchForm(props) {
    const {isRequired, message, name, field, display, key} = props;
    return (
        <Col span={8} key={key} style={{display: display ? 'block' : 'none'}}>
            <Form.Item label={name}>
                {getFieldDecorator(field, {
                    rules: [{
                        required: isRequired,
                        message: message,
                    }],
                })(
                    <Input placeholder="placeholder"/>
                )}
            </Form.Item>
        </Col>
    );
}
SearchForm.propsTypes = {
    isRequired: PropTypes.bool,
    display: PropTypes.bool,
    message: PropTypes.string,
    name: PropTypes.string,
    field: PropTypes.string,

};
export default SearchForm;