import axios, {
  AxiosInstance,
  AxiosRequestConfig,
  AxiosResponse,
  CreateAxiosDefaults,
} from 'axios';

type RequestType = 'POST' | 'GET' | 'DELETE' | 'PUT';

const createInstance = (axiosConfig?: CreateAxiosDefaults) =>
  axios.create({
    baseURL: 'https://app-metlife-team10.azurewebsites.net',
    headers: {
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Credentials': true,
    },
    ...axiosConfig,
  } as CreateAxiosDefaults);

class AxiosApi {
  private _config: CreateAxiosDefaults | undefined;
  private static instance: AxiosInstance;

  private constructor(config?: CreateAxiosDefaults) {
    this._config = config;
  }

  private static getInstance(config?: CreateAxiosDefaults) {
    if (!AxiosApi.instance) {
      this.instance = createInstance(config);
    }
    return this.instance;
  }

  public static async get<T>(url: string, config?: AxiosRequestConfig<T>) {
    return await AxiosApi.request<T>('GET', url, undefined, config);
  }

  public static async post<T, R = T>(
    uri: string,
    data?: T,
    config?: AxiosRequestConfig<T>,
  ): Promise<AxiosResponse<R>> {
    return await AxiosApi.request<T, R>('POST', uri, data ?? ({} as T), config);
  }

  public static async put<T, R = T>(
    uri: string,
    data?: T,
    config?: AxiosRequestConfig,
  ): Promise<AxiosResponse<R>> {
    return await AxiosApi.request<T, R>('PUT', uri, data ?? ({} as T), config);
  }

  public static async delete<T, R = T>(
    url: string,
    config?: AxiosRequestConfig<T>,
  ): Promise<AxiosResponse<R>> {
    return await AxiosApi.request<T, R>('DELETE', url, undefined, config);
  }

  private static async request<T, R = T>(
    requestType: RequestType,
    url: string,
    data?: T,
    config?: AxiosRequestConfig,
  ) {
    return AxiosApi.getInstance().request<T, AxiosResponse<R>>({
      method: requestType,
      url,
      data,
      ...config,
    });
  }
}

const axiosApi = AxiosApi;

export default axiosApi;
