import React, {useState, useEffect} from 'react';
import axios from 'axios';

const NewsList=()=>{
	const [articles, setArticles]=useState([]);

	useEffect(()=>{
		const fetchArticles=async()=>{
			try{
				const response=await axios.get('http://localhost:8080/news');
				setArticles(response.data);
			} catch(error){
				console.error('Error fetching articles:', error);
			}
		};
		fetchArticles();
	}, []);

	return (
	    <div>
	      <h1>News List</h1>
	      <table style={{ borderCollapse: 'collapse', width: '100%' }}>
	        <thead>
	          <tr>
	            <th style={{ border: '1px solid black', padding: '8px' }}>Title</th>
	            <th style={{ border: '1px solid black', padding: '8px' }}>Source</th>
	          </tr>
	        </thead>
	        <tbody>
	          {articles.map((article, index) => (
	            <tr key={index}>
	              <td style={{ border: '1px solid black', padding: '8px' }}>
	                <a href={article.link} target="_blank" rel="noopener noreferrer" style={{ textDecoration: 'underline', color: 'black', cursor: 'pointer' }}>
	                	{article.title}
	                </a>
	              </td>
	              <td style={{ border: '1px solid black', padding: '8px' }}>{article.source}</td>
	            </tr>
	          ))}
	        </tbody>
	      </table>
	    </div>
	  );
};

export default NewsList;