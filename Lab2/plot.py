import matplotlib.pyplot as plt
import numpy as np

n = np.arange(1, 51)
plt.figure(figsize=(10, 6))

# Calculating function values
values_squared = (n + 5)**2
values_fractional = n**(14/16)
values_linear = n + 5
values_cubic = (n + 5)**3
values_quintic = (n + 5)**5

# Plot each function with specific markers and check values
plt.plot(n, values_squared, 'o-', color='blue', label='(n+5)^2')
plt.plot(n, values_fractional, 'x-', color='orange', label='n^(14/16)')
plt.plot(n, values_linear, '^-', color='green', label='n+5')
plt.plot(n, values_cubic, 's-', color='red', label='(n+5)^3')
plt.plot(n, values_quintic, 'd-', color='purple', label='(n+5)^5')

plt.yscale('log')
plt.xlabel('n')
plt.ylabel('Function value')
plt.title('Growth Rates Comparison')
plt.legend()
plt.grid(True)
plt.show()

 



