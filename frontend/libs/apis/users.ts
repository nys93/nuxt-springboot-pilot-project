import axios, { AxiosResponse } from 'axios'
import { IUser, ICreateUser } from '~/models/user'
import { IResponse } from '~/models/response';

export const getUsers = async (): Promise<IUser[]> => {
  const axiosResponse: AxiosResponse = await axios.get(
    'http://localhost:8000/api/v1/users'
  )
  return axiosResponse.data
}

export const createUsers = async (createUser: ICreateUser): Promise<IResponse> => {
  const axiosResponse: AxiosResponse = await axios.post(
    'http://localhost:8000/api/v1/users',
    {createUser}
  )
  return { status: axiosResponse.status, message: axiosResponse.data }
}
