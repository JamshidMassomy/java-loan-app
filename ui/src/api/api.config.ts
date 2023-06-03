import { API_BASE_URL } from '../constants';

export const _fetch = (url, options: any = {}) => {
  return new Promise((resolve, reject) => {
    const fetchData = {
      method: options?.method || 'GET',
      headers: { Accept: 'application/json' },
    };
    const api = API_BASE_URL + url;
    fetch(api, fetchData).then((response) => {
      if (response.ok) {
        response.json().then((json) => resolve(json));
      } else {
        response.json().then((json) => reject(json));
      }
    });
  });
};
