/* eslint-disable no-shadow */
/* eslint-disable no-unused-vars */
enum ButtonType {
  BTN_PRIMARY = 'primary',
  BTN_GRAY = 'gray',
}
interface Button {
  text: string;
  type?: ButtonType;
  onClick?: () => void;
  border?: 'round' | 'square';
}

export { ButtonType };
export type { Button };
