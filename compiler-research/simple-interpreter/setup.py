from setuptools import setup, find_packages


setup(
    name="simple-interpreter",
    author="joecqupt",
    version="0.01",
    description="a simple interpreter",
    keywords=["interpreter"],
    packages=find_packages(exclude=["test", "tests"]),
)
