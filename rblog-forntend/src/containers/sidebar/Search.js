/**
 * Created by renjp on 2018/12/27.
 */
import React from 'react';
import {
    Icon, Button, AutoComplete,Card,Input
} from 'antd';


const Option = AutoComplete.Option;

function onSelect(value) {
    console.log('onSelect', value);
}

function getRandomInt(max, min = 0) {
    return Math.floor(Math.random() * (max - min + 1)) + min; // eslint-disable-line no-mixed-operators
}

function searchResult(query) {
    return (new Array(getRandomInt(5))).join('.').split('.')
        .map((item, idx) => ({
            query,
            category: `${query}${idx}`,
            count: getRandomInt(200, 100),
        }));
}

function renderOption(item) {
    return (
        <Option key={item.category} text={item.category}>
            {item.query} 在
            <a
                href={`https://s.taobao.com/search?q=${item.query}`}
                target="_blank"
                rel="noopener noreferrer"
            >
                {item.category}
            </a>
            中
            <span className="global-search-item-count">约 {item.count} 个结果</span>
        </Option>
    );
}

class Search extends React.Component {
    state = {
        dataSource: [],
    }

    handleSearch = (value) => {
        this.setState({
            dataSource: value ? searchResult(value) : [],
        });
    }

    render() {
        const { dataSource } = this.state;
        return (
        <Card
            hoverable="true"
        >
            <div className="global-search-wrapper">
                <AutoComplete
                    className="global-search"
                    size="large"
                    style={{ width: '100%' }}
                    dataSource={dataSource.map(renderOption)}
                    onSelect={onSelect}
                    onSearch={this.handleSearch}
                    placeholder="请输入关键字"
                    optionLabelProp="text"
                >
                    <Input
                        suffix={(
                            <Button className="search-btn" size="large" type="primary" >
                                <Icon type="search" />
                            </Button>
                        )}
                    />

                </AutoComplete>
            </div>
        </Card>
        );
    }
}
export default Search;